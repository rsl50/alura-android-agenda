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

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

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
        View viewCriada = criaView(parent);
        vincula(position, viewCriada);
        return viewCriada;
    }

    private void vincula(int position, View view) {
        Aluno aluno = alunos.get(position);
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);

        nome.setText(aluno.getNome());
        telefone.setText(aluno.getTelefone());
    }

    private View criaView(ViewGroup parent) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, parent, false); //false attachToRoot indica que o adapter vai controlar o inflate e não a listView
    }

    public void remove (Aluno aluno) {
        this.alunos.remove(aluno);
        notifyDataSetChanged();
    }

    public void atualiza (List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }
}
