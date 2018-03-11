package com.example.nieves.conecta4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
	/**
	 * Permite crear una instancia de nuestra clase
	 * @param title
	 * @return
	 */
	public static AlertDialogFragment newInstance(int title) {
		AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();// Para poder pasar el contenido
        args.putInt("title", title);
        frag.setArguments(args); // Cambiamos los argumentos
        return frag;
    }
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Actividad a la que repercute
		final MainActivity main = (MainActivity) getActivity();
		int title = getArguments().getInt("title");

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
		
		alertDialogBuilder.setTitle(title);
		alertDialogBuilder.setMessage(R.string.deseaContinuar);
		alertDialogBuilder.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) { // qué responde cuando hace eso
						main.restart();
						main.crearTablero();
						dialog.dismiss(); // quita el dialog
					}
				});
		alertDialogBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.finish();
						dialog.dismiss();
					}
				});
		return alertDialogBuilder.create();
	}
}
