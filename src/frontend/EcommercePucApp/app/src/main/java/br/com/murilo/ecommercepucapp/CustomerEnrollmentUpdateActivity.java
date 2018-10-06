package br.com.murilo.ecommercepucapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.murilo.ecommercepucapp.application.ClientFactory;
import br.com.murilo.ecommercepucapp.application.Logger;
import br.com.murilo.ecommercepucapp.application.MessageUtil;
import br.com.murilo.ecommercepucapp.entity.Customer;
import br.com.murilo.ecommercepucapp.service.CustomerClient;
import br.com.murilo.ecommercepucapp.service.model.RequestResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity responsável por operações na tela de cadastro/edição de cliente
 * @author murilocosta
 */
public class CustomerEnrollmentUpdateActivity extends AppCompatActivity {

    public static final String CUSTOMER_OBJECT_ID = "CUSTOMER_OBJECT_ID";

    private static final Logger LOGGER = Logger.create(CustomerEnrollmentUpdateActivity.class);

    private EditText cpfEditText;
    private EditText nameEditText;
    private EditText addressEditText;
    private EditText cityEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button saveButton;

    private boolean isUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_customer_enrollment_update);
        this.initialize();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, CustomerManagementActivity.class);
        this.startActivity(intent);
    }

    private void initialize() {
        this.cpfEditText = findViewById(R.id.cpfEditText);
        this.nameEditText = findViewById(R.id.nameEditText);
        this.addressEditText = findViewById(R.id.addressEditText);
        this.cityEditText = findViewById(R.id.cityEditText);
        this.phoneEditText = findViewById(R.id.phoneEditText);
        this.emailEditText = findViewById(R.id.emailEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.saveButton = findViewById(R.id.saveCustomerButton);

        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveCustomerClick(view);
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(CUSTOMER_OBJECT_ID)) {
            Customer customer = (Customer) bundle.get(CUSTOMER_OBJECT_ID);
            this.initializeCustomer(customer);
            this.isUpdate = true;
        } else {
            this.cpfEditText.setEnabled(true);
            this.isUpdate = false;
        }
    }

    private void onSaveCustomerClick(View view) {
        Customer customer = new Customer();
        customer.setCpf(this.cpfEditText.getText().toString());
        customer.setName(this.nameEditText.getText().toString());
        customer.setAddress(this.addressEditText.getText().toString());
        customer.setCity(this.cityEditText.getText().toString());
        customer.setPhone(this.phoneEditText.getText().toString());
        customer.setEmail(this.emailEditText.getText().toString());
        customer.setPassword(this.passwordEditText.getText().toString());

        if (customer.getCpf() == null || customer.getCpf().isEmpty()) {
            MessageUtil.showLongToast(this, "CPF não pode ser vazio!");
            return;
        }

        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            MessageUtil.showLongToast(this, "Email não pode ser vazio!");
            return;
        }

        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            MessageUtil.showLongToast(this, "Senha não pode ser vazia!");
            return;
        }

        ClientFactory clientFactory = ClientFactory.getInstance();
        CustomerClient customerClient = clientFactory.createCustomerClient();

        final Call<RequestResult<Customer>> requestResult;

        if (isUpdate) {
            requestResult = customerClient.update(customer);
        } else {
            requestResult = customerClient.add(customer);
        }

        requestResult.enqueue(new Callback<RequestResult<Customer>>() {
            @Override
            public void onResponse(Call<RequestResult<Customer>> call, Response<RequestResult<Customer>> response) {
                RequestResult<Customer> result = response.body();

                if (!result.isRequestSuccessful()) {
                    MessageUtil.showLongToast(CustomerEnrollmentUpdateActivity.this, result.getMessage());
                } else {
                    MessageUtil.showLongToast(CustomerEnrollmentUpdateActivity.this, result.getMessage());
                    backToCustomerManagement();
                }
            }

            @Override
            public void onFailure(Call<RequestResult<Customer>> call, Throwable t) {
                MessageUtil.showLongToast(CustomerEnrollmentUpdateActivity.this, "Ocorreu um erro ao salvar cliente!");
                LOGGER.error(t.getMessage());
            }
        });
    }

    private void initializeCustomer(Customer customer) {
        this.cpfEditText.setText(customer.getCpf());
        this.nameEditText.setText(customer.getName());
        this.addressEditText.setText(customer.getAddress());
        this.cityEditText.setText(customer.getCity());
        this.phoneEditText.setText(customer.getPhone());
        this.emailEditText.setText(customer.getEmail());
        this.passwordEditText.setText(customer.getPassword());

        this.cpfEditText.setEnabled(false);
    }

    private void backToCustomerManagement() {
        Intent intent = new Intent(this, CustomerManagementActivity.class);

        if (this.isUpdate) {
            intent.putExtra(CustomerManagementActivity.REFRESH_SEARCH_ID, true);
        }

        this.startActivity(intent);
    }
}
