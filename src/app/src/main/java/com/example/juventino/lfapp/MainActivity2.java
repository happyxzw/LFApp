package com.example.juventino.lfapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.juventino.lfapp.vo.*;


import org.w3c.dom.Text;

import static com.example.juventino.lfapp.R.layout.out;


public class MainActivity2 extends ActionBarActivity {

    private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    private LinearLayout l1, l2, l3, l4, l5, l6, l7, l8, l9;
    private boolean z1, z2, z3, z4, z5, z6, z7, z8, z9;
    private Button button_Voltar;
    private TextView step1_1, step1_2, step2_1, step2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.out);

        String mensagem = new String();
        //pegando Intent para retirar o que foi enviado da tela anterior
        Intent intent = getIntent();
        if (intent != null) {
            Bundle dados = new Bundle();
            dados = intent.getExtras();
            if (dados != null) {
                mensagem = dados.getString("msg");

                Grammar g = new Grammar(mensagem);
                Grammar gc = (Grammar) g.clone();

                String descricao = new String();
                String grammarAux = new String();

                //REMOÇÃO DE SÍMBOLO INICIAL RECURSIVO
                gc = g.getGrammarWithInitialSymbolNotRecursive(g);
                grammarAux = printRules(gc);
                descricao = "Assuma uma GLC G = (V, Σ, P, " + g.getInitialSymbol() + ") onde " + g.getInitialSymbol() + " é recurssivo, logo: ";
                descricao += "\n - G' = (V U {" + gc.getInitialSymbol() +"}, Σ, P U {" + gc.getInitialSymbol() + "->" + g.getInitialSymbol() + "}, "
            + gc.getInitialSymbol() + ")";
                descricao += "\n - L(G) = L(G')";
                step1_1 = (TextView) findViewById(R.id.DescricaoAlgoritmo1);
                step1_1.setText(descricao);

                step1_2 = (TextView) findViewById(R.id.Algoritmo1);
                step1_2.setText(grammarAux);

                //REMOÇÃO DE PRODUÇOES VAZIAS
                descricao = "1.\nNULL = { A | {A -> .} ∈ P}\nrepita\n     PREV = NULL \n     para cada A ∈ V faça";
                descricao += "\n          se A -> w e w ∈ PREV* faça \n                    NULL = NULL U {A}\n";
                descricao += "até NULL == PREV\n\n";
                descricao += "2. \n - Remoção de todos os lambda\n - Busca por variáveis que produzem lambda indiretamente\n - Eliminação " +
                        "de regras que produzem vazio";
                step2_1 = (TextView) findViewById(R.id.DescricaoAlgoritmo2);
                step2_1.setText(descricao);

                gc = g.getGrammarEssentiallyNoncontracting(g);
                grammarAux = printRules(gc);
                step2_2 = (TextView) findViewById(R.id.Algoritmo2);
                step2_2.setText(grammarAux);



            }
        }



        this.t1 = (TextView) findViewById(R.id.layouttext1);
        this.t2 = (TextView) findViewById(R.id.layouttext2);
        this.t3 = (TextView) findViewById(R.id.layouttext3);
        this.t4 = (TextView) findViewById(R.id.layouttext4);
        this.t5 = (TextView) findViewById(R.id.layouttext5);
        this.t6 = (TextView) findViewById(R.id.layouttext6);
        this.t7 = (TextView) findViewById(R.id.layouttext7);
        this.t8 = (TextView) findViewById(R.id.layouttext8);
        this.t9 = (TextView) findViewById(R.id.layouttext9);

        this.l1 = (LinearLayout) findViewById(R.id.layout1);
        this.l2 = (LinearLayout) findViewById(R.id.layout2);
        this.l3 = (LinearLayout) findViewById(R.id.layout3);
        this.l4 = (LinearLayout) findViewById(R.id.layout4);
        this.l5 = (LinearLayout) findViewById(R.id.layout5);
        this.l6 = (LinearLayout) findViewById(R.id.layout6);
        this.l7 = (LinearLayout) findViewById(R.id.layout7);
        this.l8 = (LinearLayout) findViewById(R.id.layout8);
        this.l9 = (LinearLayout) findViewById(R.id.layout9);

        this.l1.setVisibility(View.GONE);
        this.l2.setVisibility(View.GONE);
        this.l3.setVisibility(View.GONE);
        this.l4.setVisibility(View.GONE);
        this.l5.setVisibility(View.GONE);
        this.l6.setVisibility(View.GONE);
        this.l7.setVisibility(View.GONE);
        this.l8.setVisibility(View.GONE);
        this.l9.setVisibility(View.GONE);

        z1 = true;
        this.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z1) {
                    l1.setVisibility(View.GONE);
                    z1 = false;
                } else {
                    l1.setVisibility(View.VISIBLE);
                    z1 = true;
                }
            }
        });

        z2 = true;
        this.t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z2) {
                    l2.setVisibility(View.GONE);
                    z2 = false;
                } else {
                    l2.setVisibility(View.VISIBLE);
                    z2 = true;
                }
            }
        });

        z3 = true;
        this.t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z3) {
                    l3.setVisibility(View.GONE);
                    z3 = false;
                } else {
                    l3.setVisibility(View.VISIBLE);
                    z3 = true;
                }
            }
        });

        z4 = true;
        this.t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z4) {
                    l4.setVisibility(View.GONE);
                    z4 = false;
                } else {
                    l4.setVisibility(View.VISIBLE);
                    z4 = true;
                }
            }
        });

        z5 = true;
        this.t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z5) {
                    l5.setVisibility(View.GONE);
                    z5 = false;
                } else {
                    l5.setVisibility(View.VISIBLE);
                    z5 = true;
                }
            }
        });

        z6 = true;
        this.t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z6) {
                    l6.setVisibility(View.GONE);
                    z6 = false;
                } else {
                    l6.setVisibility(View.VISIBLE);
                    z6 = true;
                }
            }
        });

        z7 = true;
        this.t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z7) {
                    l7.setVisibility(View.GONE);
                    z7 = false;
                } else {
                    l7.setVisibility(View.VISIBLE);
                    z7 = true;
                }
            }
        });

        z8 = true;
        this.t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z8) {
                    l8.setVisibility(View.GONE);
                    z8 = false;
                } else {
                    l8.setVisibility(View.VISIBLE);
                    z8 = true;
                }
            }
        });

        z9 = true;
        this.t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z9) {
                    l9.setVisibility(View.GONE);
                    z9 = false;
                } else {
                    l9.setVisibility(View.VISIBLE);
                    z9 = true;
                }
            }
        });

        this.button_Voltar = (Button) findViewById(R.id.button_Voltar);
        this.button_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TrocaTela = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(TrocaTela);
                finish();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String printRules(final Grammar g) {
        String out = new String();
        for (Rule element : g.getRules()) {
            if (element.getLeftSide().equals(g.getInitialSymbol())) {
                out += element.toString() + "\n";
            }
        }

        for (String variable : g.getVariables()) {
            for (Rule element : g.getRules()) {
                if (!variable.equals(g.getInitialSymbol()) && variable.equals(element.getLeftSide())) {
                    out += element.toString() + "\n";
                }
            }
        }
        return out;
    }
}
