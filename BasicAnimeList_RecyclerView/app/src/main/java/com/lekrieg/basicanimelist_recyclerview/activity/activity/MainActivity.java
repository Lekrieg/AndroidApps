package com.lekrieg.basicanimelist_recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lekrieg.basicanimelist_recyclerview.R;
import com.lekrieg.basicanimelist_recyclerview.activity.RecyclerItemClickListener;
import com.lekrieg.basicanimelist_recyclerview.activity.adapter.AdapterAnimes;
import com.lekrieg.basicanimelist_recyclerview.activity.model.Anime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerViewAnimes;

	private List<Anime> animeList = new ArrayList<>();

	// As informacoes viriam de um banco de dados, uma consulta ou um arquivo com os dados, estou usando um array apenas por praticidade momentanea
	private String[] descriptions = {
			"Arte was born into an aristocratic family in Florence during the 16th century Renaissance era. Being female, it was unheard of for one to become an artist. Driven by her love of art, Arte is willing to cast aside her aristocratic lifestyle to become an artist.\n",
			"Hole—a dark, decrepit, and disorderly district where the strong prey on the weak and death is an ordinary occurrence—is all but befitting of the name given to it. A realm separated from law and ethics, it is a testing ground to the magic users who dominate it. As a race occupying the highest rungs of their society, the magic users think of the denizens of Hole as no more than insects. Murdered, mutilated, and made experiments without a second thought, the powerless Hole dwellers litter the halls of Hole's hospital on a daily basis.",
			"What does one consider to be a monster? A horrible bloodsucking vampire? Frankenstein's creation? Shuichi Kagaya has a secret. Other than having great grades and being skilled at sports, he isn’t what one would call normal. In fact, Shuichi cannot even be considered human.",
			"Second half of Honzuki no Gekokujou: Shisho ni Naru Tame ni wa Shudan wo Erandeiraremasen.",
			"Second season of Kaguya-sama wa Kokurasetai: Tensai-tachi no Renai Zunousen.",
			"\"We will open the curtain back in time, to the story of one lone manga creator.\"\n" +
					"\n" +
					"This story is about Gotou Kakushi, an artist who draws a somewhat vulgar manga, and tries to hide it for the sake of his daughter, Hime. A father-daughter tale of love and laughter.",
			"Third season of Kingdom.",
			"Second part of Sword Art Online: Alicization - War of Underworld.",
			"Fifth season of Shokugeki no Souma.\n"

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerViewAnimes = findViewById(R.id.recyclerViewAnimes);

		// Lista animes
		createAnimes();

		// Configurar adapter
		AdapterAnimes adapter = new AdapterAnimes(animeList);

		// Configurar recyclerView
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerViewAnimes.setLayoutManager(layoutManager);
		recyclerViewAnimes.setHasFixedSize(true);
		recyclerViewAnimes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
		recyclerViewAnimes.setAdapter(adapter);

		// Evento de clique
		recyclerViewAnimes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerViewAnimes, new RecyclerItemClickListener.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {

				String description = descriptions[position];
				Anime anime = animeList.get(position);

				// Cria o intent e seta os dados para passar para a proxima activity
				Intent intent = new Intent(getApplicationContext(), AnimeInfoActivity.class);
				intent.putExtra("image", anime.getAnimeImage());
				intent.putExtra("name", anime.getAnimeTitle());
				intent.putExtra("description", description);

				// Mosta uma mensagem
				Toast.makeText(getApplicationContext(), "Anime: " + anime.getAnimeTitle(), Toast.LENGTH_SHORT).show();

				startActivity(intent);
			}

			@Override
			public void onLongItemClick(View view, int position) {

			}

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

			}
		}));
	}

	// Como no array de strings, as informacao seria algo retornado de um banco de dados ou algo do tipo
	public void createAnimes()
	{
		Anime anime = new Anime(R.drawable.arte , "Arte", "2020", "Slice of life");
		animeList.add(anime);

		anime = new Anime(R.drawable.dorohedoro , "Dorohedoro", "2020", "Acao/Comedia");
		animeList.add(anime);

		anime = new Anime(R.drawable.gleipnir , "Gleipnir", "2020", "Action/Mistery");
		animeList.add(anime);

		anime = new Anime(R.drawable.honzuki , "Honzuki season 2", "2020", "Slice of life/Fantasy");
		animeList.add(anime);

		anime = new Anime(R.drawable.kaguya , "Kaguya-sama season 2", "2020", "Romance/Comedy");
		animeList.add(anime);

		anime = new Anime(R.drawable.kakushigoto , "Kakushigoto", "2020", "Slice of life/Comedy");
		animeList.add(anime);

		anime = new Anime(R.drawable.kingdom , "Kingdom season 3", "2020", "Action/Military");
		animeList.add(anime);

		anime = new Anime(R.drawable.sao , "SAO Alicization", "2020", "Action/Game");
		animeList.add(anime);

		anime = new Anime(R.drawable.skugeki , "Shokugeki season 5", "2020", "Shounen/School");
		animeList.add(anime);
	}
}
