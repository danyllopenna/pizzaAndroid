package com.example.pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class tela2 extends AppCompatActivity {
    // declaração de componentes
    TextView txtNome,txtendereco,txtPizza,txtRefri,txtValor,txtAvaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        // integrando xml e java
        txtNome = findViewById(R.id.idtxt2_nome);
        txtendereco = findViewById(R.id.idtxt2_end);
        txtPizza = findViewById(R.id.idtxt2_sabor);
        txtRefri = findViewById(R.id.idtxt2_refri);
        txtValor = findViewById(R.id.idtxt2_valor);
        txtAvaliacao = findViewById(R.id.idtxt2_av);

        // 3 - pegar a intent repassada
        Intent i = getIntent();
        String nomeTela1 = "",enderecoTela1="",saborTela1="",tamanhoTela1="",respRefritela1="";
        double avaliacaoTela1=0.0,valorpizzatela1=0.0;
        if (i.hasExtra("nome")){
            nomeTela1 = i.getStringExtra("nome");
        }
        if (i.hasExtra("endereco")){
            enderecoTela1 = i.getStringExtra("endereco");
        }
        if (i.hasExtra("sabor")){
            saborTela1 = i.getStringExtra("sabor");
        }
        if (i.hasExtra("tamanho")){
            tamanhoTela1 = i.getStringExtra("tamanho");
        }
        if (i.hasExtra("refrigerante")){
            respRefritela1 = i.getStringExtra("refrigerante");
        }
        if (i.hasExtra("avaliacao")){
            avaliacaoTela1 = i.getDoubleExtra("avaliacao",0.0);
        }
        if (i.hasExtra("valor")){
            valorpizzatela1 = i.getDoubleExtra("valor",0.0);
        }
        // 4- atribuir os valores no textView
        txtNome.setText("nome : " +nomeTela1);
        txtendereco.setText(enderecoTela1);
        txtPizza.setText(saborTela1 + "("+tamanhoTela1+")");
        txtRefri.setText("Refrigerante 2L : " +respRefritela1);
        txtValor.setText("R$ "+valorpizzatela1);
        txtAvaliacao.setText(String.valueOf(avaliacaoTela1));


    } // fim do oncreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_tela2,menu);
      return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemselecionado = item.getItemId();
        if (itemselecionado == R.id.acao_compartilhar) {
            String frase = "Acabei de pedir uma pizza " + txtPizza + "peça voce tambem pelo App";
            //criar intent implicita
            Intent j = new Intent(Intent.ACTION_SEND);
            j.setType("text/plain");
            j.putExtra(Intent.EXTRA_SUBJECT,"pedido de pizza");
            j.putExtra(Intent.EXTRA_TEXT,frase);

            startActivity(Intent.createChooser(j,"Compartilhar..."));
        }
        return super.onOptionsItemSelected(item);
    }
}// fim da classe tela2
