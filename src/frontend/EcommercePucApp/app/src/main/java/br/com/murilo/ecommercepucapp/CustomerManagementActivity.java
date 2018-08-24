package br.com.murilo.ecommercepucapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.murilo.ecommercepucapp.application.ClientFactory;
import br.com.murilo.ecommercepucapp.application.Logger;
import br.com.murilo.ecommercepucapp.application.MessageUtil;
import br.com.murilo.ecommercepucapp.entity.Customer;
import br.com.murilo.ecommercepucapp.service.CustomerClient;
import br.com.murilo.ecommercepucapp.service.model.RequestResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerManagementActivity extends AppCompatActivity {

    public static final String REFRESH_SEARCH_ID = "REFRESH_SEARCH_ID";
    private static final Logger LOGGER = Logger.create(CustomerManagementActivity.class);

    private Button newCustomerButton;
    private EditText customerNameSearchEditText;
    private Button customerSearchButton;
    private ListView customerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_customer_management);
        this.initialize();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, EmployeeMenuActivity.class);
        this.startActivity(intent);
    }

    public void editCustomer(Customer customer) {
        this.showUpdateScreen(customer);
    }

    public void deleteCustomer(final Customer customer) {
        AlertDialog removeDialog = new AlertDialog.Builder(this)
                .setTitle("Remover")
                .setMessage("Deseja mesmo remover o cliente?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        performCustomerDelete(customer);
                        dialog.dismiss();
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();

        removeDialog.show();
    }

    private void initialize() {
        this.newCustomerButton = findViewById(R.id.newCustomerButton);
        this.customerNameSearchEditText = findViewById(R.id.customerNameSearchEditText);
        this.customerSearchButton = findViewById(R.id.customerSearchButton);
        this.customerListView = findViewById(R.id.customerListView);

        this.newCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewCustomerClick(view);
            }
        });

        this.customerSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCustomerSearchClick(view);
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(REFRESH_SEARCH_ID)) {
            performCustomerSearch();
        }
    }

    private void performCustomerDelete(Customer customer) {
        ClientFactory clientFactory = ClientFactory.getInstance();
        CustomerClient customerClient = clientFactory.createCustomerClient();

        final Call<RequestResult<Customer>> requestResult = customerClient.remove(customer);

        requestResult.enqueue(new Callback<RequestResult<Customer>>() {
            @Override
            public void onResponse(Call<RequestResult<Customer>> call, Response<RequestResult<Customer>> response) {
                RequestResult result = response.body();

                if (result.isRequestSuccessful()) {
                    MessageUtil.showLongToast(CustomerManagementActivity.this, "Cliente removido com sucesso!");
                    performCustomerSearch();
                } else {
                    MessageUtil.showLongToast(CustomerManagementActivity.this, result.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RequestResult<Customer>> call, Throwable t) {
                MessageUtil.showLongToast(CustomerManagementActivity.this, "Ocorreu um erro ao remover o cliente!");
                LOGGER.error(t.getMessage());
            }
        });
    }

    private void onNewCustomerClick(View view) {
        this.showEnrollmentScreen();
    }

    private void onCustomerSearchClick(View view) {
        this.performCustomerSearch();
    }

    private void performCustomerSearch() {
        String name = this.customerNameSearchEditText.getText().toString();

        ClientFactory clientFactory = ClientFactory.getInstance();
        CustomerClient customerClient = clientFactory.createCustomerClient();

        Call<List<Customer>> customerList;

        if (name != null && !name.isEmpty()) {
            customerList = customerClient.getListByName(name);
        } else {
            customerList = customerClient.getAll();
        }

        customerList.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                List<Customer> result = response.body();

                if (result.isEmpty()) {
                    MessageUtil.showShortToast(CustomerManagementActivity.this, "Não foram encontrados clientes!");
                }

                fillCustomerList(result);
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                MessageUtil.showLongToast(CustomerManagementActivity.this, "Ocorreu um erro ao listar clientes!");
                LOGGER.error(t.getMessage());
            }
        });
    }

    private void fillCustomerList(List<Customer> customers) {
        CustomerManagementListAdapter adapter = new CustomerManagementListAdapter(this, customers);
        this.customerListView.setAdapter(adapter);
    }

    private void showEnrollmentScreen() {
        this.showUpdateScreen(null);
    }

    private void showUpdateScreen(Customer customer) {
        Intent intent = new Intent(CustomerManagementActivity.this, CustomerEnrollmentUpdateActivity.class);

        if (customer != null) {
            intent.putExtra(CustomerEnrollmentUpdateActivity.CUSTOMER_OBJECT_ID, customer);
        }

        this.startActivity(intent);
    }
}
