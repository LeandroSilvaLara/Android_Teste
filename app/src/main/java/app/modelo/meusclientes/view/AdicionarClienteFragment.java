package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
    TextView editTelefone;
    TextView editEmail;
    TextView editCep;
    TextView editLogradouro;
    TextView editLNumero, edittBairro, edtitCidade, editEstado;


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

                clienteController.incluir((novoCliente));

            }
        });

        }



}
