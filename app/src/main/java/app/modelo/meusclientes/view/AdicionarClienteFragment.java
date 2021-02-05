package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    // Declração GLOBAL de atributos - variável golbais

    View view;

    TextView txtTitulo;

    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editLNumero, edittBairro, edtitCidade, editEstado;


    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;


    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        IniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }


    /**
     * Inicarlizar os componetes da tela/çayout
     * para adicionar os clientes
     */
    private void IniciarComponentesDeLayout() {




        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novoCliente);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editNCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        edittBairro = view.findViewById(R.id.editBairro);
        editLNumero = view.findViewById(R.id.editNumero);
        edtitCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.checkTermos);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);


        novoCliente = new Cliente();

        clienteController = new ClienteController(getContext());

    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Considerando que o usuário
                // digitou todos os dados
                boolean isDadosOK = true;

                // False verdadeiro
                if(TextUtils.isEmpty(editNomeCompleto.getText())){
                    isDadosOK = false;

                    editNomeCompleto.setError("Digite o nome Completo....");
                    editNomeCompleto.requestFocus();

                }

                if(TextUtils.isEmpty(editTelefone.getText())){
                    isDadosOK = false;

                    editTelefone.setError("Digite o teçefone....");
                    editTelefone.requestFocus();

                }

                if(TextUtils.isEmpty(editEmail.getText())){
                    isDadosOK = false;

                    editEmail.setError("Digite o email....");
                    editEmail.requestFocus();

                }

                if(TextUtils.isEmpty(editCep.getText())){
                    isDadosOK = false;

                    editCep.setError("Digite o cep....");
                    editCep.requestFocus();

                }

                if(TextUtils.isEmpty(editLogradouro.getText())){
                    isDadosOK = false;

                    editLogradouro.setError("Digite o av, rua....");
                    editLogradouro.requestFocus();

                }

                if(TextUtils.isEmpty(editLNumero.getText())){
                    isDadosOK = false;

                    editLNumero.setError("Digite o número....");
                    editLNumero.requestFocus();

                }

                if(TextUtils.isEmpty(edittBairro.getText())){
                    isDadosOK = false;

                    edittBairro.setError("Digite o bairro....");
                    edittBairro.requestFocus();

                }

                if(TextUtils.isEmpty(edtitCidade.getText())){
                    isDadosOK = false;

                    edtitCidade.setError("Digite o cidade....");
                    edtitCidade.requestFocus();

                }

                if(TextUtils.isEmpty(editEstado.getText())){
                    isDadosOK = false;

                    editEstado.setError("Digite o estado (UF)....");
                    editEstado.requestFocus();

                }


                if(isDadosOK){

                    //popular os dados no objeto cliente.

                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    //Cast
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));

                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editLNumero.getText().toString());
                    novoCliente.setBairro(edittBairro.getText().toString());
                    novoCliente.setBairro(edtitCidade.getText().toString());
                    novoCliente.setBairro(editEstado.getText().toString());

                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());

                    clienteController.incluir((novoCliente));
                    Log.i("log_add_cliente", "onClick: Dados Correto...");
                }else{
                    // Notificar o usuário
                    // TOAST
                    // Push Notification
                    // AlertDialog
                    
                    // LogCat
                    Log.e("log_add_cliente", "onClick: Dados incorreto...");
                }
            }
        });

        }



}
