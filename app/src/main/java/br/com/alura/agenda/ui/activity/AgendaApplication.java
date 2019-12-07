package br.com.alura.agenda.ui.activity;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();

        dao.salva(new Aluno("Robson", "123", "a@b.com"));
        dao.salva(new Aluno("Fran", "456", "z@x.com"));
    }
}
