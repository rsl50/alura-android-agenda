package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.activity.ListaAlunosActivity;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, parent, false); //false attachToRoot indica que o adapter vai controlar o inflate e não a listView


        Aluno alunoDevolvido = alunos.get(position);
        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);

        nome.setText(alunoDevolvido.getNome());
        telefone.setText(alunoDevolvido.getTelefone());

        return viewCriada;
    }

    public void clear () {
        this.alunos.clear();
    }

    public void remove (Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public void addAll (List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }
}
