package br.com.imc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ImcActivity extends Activity {

	EditText peso, altura, resultado;
	Button calcular;
	CheckBox cbMasculino, cbFeminino;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imc);

		peso = (EditText) findViewById(R.id.edtPeso);
		altura = (EditText) findViewById(R.id.edtAltura);
		resultado = (EditText) findViewById(R.id.edtResultado);
		calcular = (Button) findViewById(R.id.btCalculat);
		cbFeminino = (CheckBox) findViewById(R.id.cbFemnino);
		cbMasculino = (CheckBox) findViewById(R.id.cbMasculino);

		cbFeminino.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cbMasculino.setChecked(false);

			}
		});

		cbMasculino.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cbFeminino.setChecked(false);

			}
		});

		calcular.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Double alt = Double.parseDouble(altura.getText().toString());
				Double ps = Double.parseDouble(peso.getText().toString());

				try {

					if ((alt.equals("")) & (ps.equals(""))) {

					}
				} catch (Exception e) {
					AlertDialog.Builder msg = new AlertDialog.Builder(
							ImcActivity.this);
					msg.setTitle("Erro");
					msg.setMessage("Verifique se o peso e a altura foram digitados.");
					msg.setNeutralButton("OK", null);
					msg.show();
				}

				Double alt2 = Math.pow(alt, 2);

				Double res = ps / alt2;

				String re = String.valueOf(res);
				re = re.substring(0, 5);
				res = Double.parseDouble(re);
				
				mensagemExibir("IMC", "Seu IMC é: " + res);

			}
		});

	}

	public void mensagemExibir(String titulo, String texto) {
		AlertDialog.Builder mensagem = new AlertDialog.Builder(
				ImcActivity.this);
		mensagem.setTitle(titulo);
		mensagem.setMessage(texto);
		mensagem.setNeutralButton("OK", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				

			}
		});
		mensagem.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_imc, menu);
		return true;
	}

}
