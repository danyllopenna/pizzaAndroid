package com.example.pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    // declaração de variaveis para componentes dinamicos
    private EditText editNome, editEndereco;
    private Spinner spinSaborPizza;
    private RadioGroup rgTamanho;
    private Switch swRefri;
    private RatingBar rbAvaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // integração xml e java
        editNome = findViewById(R.id.id_nome);
        editEndereco = findViewById(R.id.id_endereco);
        spinSaborPizza = findViewById(R.id.id_spinner);
        rgTamanho = findViewById(R.id.id_radioGroup);
        swRefri = findViewById(R.id.id_switch);
        rbAvaliacao = findViewById(R.id.id_rating);
    }

    // 3 - tornar o menu visivel
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }
    // 4 - controle de clique (ação)

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemselecionado = item.getItemId();
        if (itemselecionado == R.id.acao_pedir) {
            // 5- pegar os valores selecionados na tela 1
            String nomedigitado = editNome.getText().toString();
            String enderecoDigitado = editEndereco.getText().toString();
            String saborEscolhido = spinSaborPizza.getSelectedItem().toString();
            String tamanhoEscolhido = " ";
            double valorPizza = 0.0;
            int idRadioTamanho = rgTamanho.getCheckedRadioButtonId();
            switch (idRadioTamanho) {
                case R.id.id_pequena:
                    tamanhoEscolhido = "pequena";
                    valorPizza = valorPizza+25.0;
                    break;

                case R.id.id_media:
                    tamanhoEscolhido = "media";
                    valorPizza = valorPizza + 38.0;
                    break;

                case R.id.id_grande:
                    tamanhoEscolhido = "grande";
                    valorPizza = valorPizza + 45.0;
                    break;
                default:
                    tamanhoEscolhido = "invalido";
            } // fim do switch
            if (swRefri.isChecked()){
                valorPizza = valorPizza + 7.0;
            }
            String respRegfri = swRefri.isChecked() == true ? "sim" : "não";
            double avaliacaoEscolhida = rbAvaliacao.getRating();

            //6 - passando parametros pra outra tela
            // intent explicita
            Intent irtela2 = new Intent(this,tela2.class);
            irtela2.putExtra("nome",nomedigitado);
            irtela2.putExtra("endereco",enderecoDigitado);
            irtela2.putExtra("sabor",saborEscolhido);
            irtela2.putExtra("tamanho",tamanhoEscolhido);
            irtela2.putExtra("refrigerante",respRegfri);
            irtela2.putExtra("avaliacao",avaliacaoEscolhida);
            irtela2.putExtra("valor",valorPizza);

            startActivity(irtela2);


        }
        return super.onOptionsItemSelected(item);
    }
}

