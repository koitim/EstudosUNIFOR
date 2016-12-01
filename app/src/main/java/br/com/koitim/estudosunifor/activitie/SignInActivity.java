package br.com.koitim.estudosunifor.activitie;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.koitim.estudosunifor.R;
import br.com.koitim.estudosunifor.model.User;
import br.com.koitim.estudosunifor.repository.UserRepository;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNome;
    private EditText etUserName;
    private EditText etSenha;
    private Button btSalvar;

    private UserRepository ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ur = UserRepository.getInstance();

        etNome = (EditText) findViewById(R.id.signin_et_nome);
        etUserName = (EditText) findViewById(R.id.signin_et_username);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btSalvar = (Button) findViewById(R.id.signin_bt_salvar);

        btSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_bt_salvar:
                String nome = etNome.getText().toString();
                String userName = etUserName.getText().toString();
                String senha = etSenha.getText().toString();
                boolean isValid = true;
                if (nome.isEmpty()) {
                    etNome.setError("O campo nome não pode ser vazio");
                    isValid = false;
                }
                if (userName.isEmpty()) {
                    etUserName.setError("O campo usuario não pode ser vazio");
                    isValid = false;
                }
                if (senha.isEmpty()) {
                    etSenha.setError("O campo senha não pode ser vazio");
                    isValid = false;
                }
                if (isValid) {
                    User user = new User(nome, userName, senha);
                    ur.insert(user);
                    Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Snackbar.make(view, "Preencha os campos conforme indicado.", Snackbar.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
