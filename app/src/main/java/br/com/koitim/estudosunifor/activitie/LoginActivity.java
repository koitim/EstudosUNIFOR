package br.com.koitim.estudosunifor.activitie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.koitim.estudosunifor.R;
import br.com.koitim.estudosunifor.model.User;
import br.com.koitim.estudosunifor.repository.UserRepository;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText etLogin;
    private EditText etSenha;
    private TextView tvCadastro;
    private Button btLogin;

    private UserRepository ur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ur = UserRepository.getInstance();

        etLogin = (EditText) findViewById(R.id.et_login);
        etSenha = (EditText) findViewById(R.id.et_senha);
        tvCadastro = (TextView) findViewById(R.id.tv_cadastro);
        btLogin = (Button) findViewById(R.id.bt_login);
        tvCadastro.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String userName = etLogin.getText().toString();
                String senha = etSenha.getText().toString();
                boolean isValid = true;
                if (userName.isEmpty()) {
                    etLogin.setError("O nome de usuário não pode ser vazio.");
                    isValid = false;
                }
                if (senha.isEmpty()) {
                    etSenha.setError("A senha não pode ser vazia.");
                    isValid = false;
                }
                if (isValid) {
                    List<User> users = ur.findAll();
                    for (User user: users) {
                        if (user.getUserName().equals(userName) &&
                                user.getPassword().equals(senha)) {
                            Intent it = new Intent(this, MainActivity.class);
                            startActivity(it);
                            finish();
                        }
                    }
                    Snackbar.make(view, "Usuário ou senha inválidos.", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "Preencha os campos solicitados.", Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_cadastro:
                Intent it = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(it);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Situação inesperada!", Toast.LENGTH_LONG).show();
        }
    }
}

