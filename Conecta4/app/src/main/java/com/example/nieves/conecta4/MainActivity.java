package com.example.nieves.conecta4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Nieves Borrero
 */
public class MainActivity extends Activity implements OnClickListener{
	private final int ids[][] = {{R.id.a1, R.id.a2,R.id.a3,R.id.a4,R.id.a5,R.id.a6,R.id.a7},
			{R.id.b1, R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7},
			{R.id.c1, R.id.c2,R.id.c3,R.id.c4,R.id.c5,R.id.c6,R.id.c7},
			{R.id.d1, R.id.d2,R.id.d3,R.id.d4,R.id.d5,R.id.d6,R.id.d7},
			{R.id.e1, R.id.e2,R.id.e3,R.id.e4,R.id.e5,R.id.e6,R.id.e7},
			{R.id.f1, R.id.f2,R.id.f3,R.id.f4,R.id.f5,R.id.f6,R.id.f7}};
	
	private Game game;
	private ImageButton bValidar;
	private TextView resultadoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		game = new Game();
		
		String x [] = getResources().getStringArray(R.array.colores);
		
		for(int i = 0; i< Game.NFILAS;  i++){
			for (int j = 0; j < Game.NCOLUMNAS;  j++){
				bValidar  = (ImageButton) findViewById(ids[i][j]);
				bValidar.setOnClickListener(this);
			}
		}	
		resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
	}

	/*
	*
	*
	*/
	public void onSaveInstanceState(Bundle outState){ // Buddle->contenedor
		outState.putString("TABLERO", game.gridToString());// Los datos se almacenan como un par nombre-valor.
		//Guarda el estado asociado con una instancia actual de una Actividad
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case R.id.about:
				Intent intent = new Intent(getApplicationContext(), About.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Recupera el estado guardado en la aplicación
	 * @param savedInstanceState
	 */
	public void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String grid = savedInstanceState.getString("TABLERO");
        game.stringToGrid(grid);
        crearTablero();
    }
	


	protected void onResume(){
		super.onResume();
		Music.play(this, R.raw.musica);
	   	crearTablero();

    }


    protected void onPause(){
		super.onPause();
		Music.stop(this);
    }


	/**
	 * Dibuja el tablero
 	 */
	public void crearTablero() {
	   int id = 0;
	   int color;
	   color = R.color.red;

	   for (int i = 0; i < Game.NFILAS; i++)
		   for (int j = 0; j < Game.NCOLUMNAS; j++) {
			   if(game.indicaCasilla(i,j)==Game.MAQUINA){
				   id = R.color.yellow;
			   }
			   else if(game.indicaCasilla(i,j) == Game.JUGADOR){
				   id = color;
			   }
			   else{
				   id = R.color.light_blue;
			   }
			   ImageButton imageButton = (ImageButton) findViewById(ids[i][j]);
			   GradientDrawable drawable = (GradientDrawable) imageButton.getDrawable();
			   drawable.setColor(getResources().getColor(id));
		   }
   }

   public void onClick (View v){
		pulsado(v);
	}

	/**
	 * Lo que ocurre cuando el usuario pulsa.
	 * @param v
	 */
   public void pulsado(View v) {
       int fila, columna, id = v.getId();
       
       fila = deIdentificadorAFila(id);
       columna = deIdentificadorAColumna(id);
       
	   //Comprobamos si puede mover ficha a una casilla.
       if (game.puedeMover(fila, columna) != true) {
           Toast.makeText(this, "No se puede colocar ficha",
                   Toast.LENGTH_SHORT).show();
           return;// Si no puede, salimos
       }

       // Decimos que esa casilla pertenece al jugador.
       game.mueveJugador(fila, columna);

       // Comprobamos quién ha ganado.
       if(game.checkWinnerGame(Game.JUGADOR, fila, columna)){
           crearTablero();// Volvemos a dibujar el tablero una vez ha colocado.
		AlertDialogFragment.newInstance(R.string.ganaJugador).show(getFragmentManager(), "ALERT DIALOG");
       }
       else{
	       int posicion [] = game.juegaMaquina();       
	       
	       if(game.checkWinnerGame(Game.MAQUINA, posicion[0], posicion[1])){
	    	   crearTablero(); // Volvemos a dibujar el tablero una vez ha colocado.
	    	   AlertDialogFragment.newInstance(R.string.ganaMaquina).show(getFragmentManager(), "ALERT DIALOG");
	       }
	       else{
	    	   crearTablero(); // Siempre dibujamos el tablero de nuevo, para que coja las fichas.
	    	   if (game.tableroLleno()) {
	   			AlertDialogFragment.newInstance(R.string.fullTable).show(getFragmentManager(), "ALERT DIALOG");
	   			return;
	   		}
	       }
       }
   }

	
	public int deIdentificadorAFila(int id){
		for(int i = 0; i <Game.NFILAS;  i++)
			for (int j = 0 ; j < Game.NCOLUMNAS;  j++)
				if(ids[i][j] == id)
					return i;	
		return -1;
	}
	public int deIdentificadorAColumna(int id){
		for(int i = 0; i <Game.NFILAS;  i++)
			for (int j = 0 ; j < Game.NCOLUMNAS;  j++)
				if(ids[i][j] == id)
					return j;	
		return -1;
	}
	
	public void restart(){
		game = new Game();
	}


}
