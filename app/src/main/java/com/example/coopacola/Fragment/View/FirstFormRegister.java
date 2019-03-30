package com.example.coopacola.Fragment.View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.coopacola.Interface.View.IFormRegister1View;
import com.example.coopacola.Model.User;
import com.example.coopacola.R;
import com.example.coopacola.RegisterActivity;


public class FirstFormRegister extends Fragment implements IFormRegister1View {
    private static final String TAG = "FirstFormRegister";


    TextView fullName, warningFullname, email, warningEmail, motherName, warningMotherName, identityNumber,
            warningChooseIdentityNumber, warningFillIdentityNumber, chooseGender, warningChooseGender, job,
            warningChooseJob, address, warningAddress, chooseCountry, warningChooseCountry;

    EditText inputFullName, inputEmail, inputMotherName, inputIdentityNumber, inputAddress;
    Spinner spinerIdenityNumber, spinnerGender, spinnerJob, spinnerCountry;
    View view;
    private User user = new User();;
    private boolean firstDisplay = true;
    RegisterActivity registerActivity;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View) inflater.inflate(R.layout.fragment_register_form1, container, false);
        init();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputMotherName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setMotherName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputIdentityNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setIdCardNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user.setAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinerIdenityNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user.setIdCardType(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user.setJob(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user.setGender(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user.setCountry(parent.getSelectedItem().toString());
                ((RegisterActivity)getActivity()).onFirstFormComplete(user.getEmail(),
                        user.getIdCardType(),
                        user.getIdCardNumber(),
                        user.getFullName(), user.getMotherName(),user.getGender(), user.getJob(), user.getAddress(), user.getCountry());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        registerActivity = (RegisterActivity) context;

    }



    private void init(){
        //UI fullname
        fullName = view.findViewById(R.id.textViewFullName);
        inputFullName = view.findViewById(R.id.editTextFullName);
        warningFullname = view.findViewById(R.id.textViewWarningFullName);

        //UI Email
        email = view.findViewById(R.id.textViewEmail);
        inputEmail = view.findViewById(R.id.editTextEmail);
        warningEmail = view.findViewById(R.id.textViewWarningEmail);

        //UI Mother Name
        motherName = view.findViewById(R.id.textViewMotherName);
        inputMotherName = view.findViewById(R.id.editTextMotherName);
        warningMotherName = view.findViewById(R.id.textViewWarningMotherName);

        //UI identityNumber
        identityNumber = view.findViewById(R.id.textViewIdentityNumber);
        spinerIdenityNumber = view.findViewById(R.id.spinnerIDCardType);
        inputIdentityNumber = view.findViewById(R.id.editTextIdentityNumber);
        warningChooseIdentityNumber = view.findViewById(R.id.textViewWarningChoseIdentityNumberType);
        warningFillIdentityNumber = view.findViewById(R.id.textViewWarningIdentityNumber);

        //UI Gender
        chooseGender = view.findViewById(R.id.textViewGender);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        warningChooseGender = view.findViewById(R.id.textViewWarningGender);

        //UI Job
        job = view.findViewById(R.id.textViewJob);
        spinnerJob = view.findViewById(R.id.spinnerJob);
        warningChooseJob = view.findViewById(R.id.textViewWarningJob);

        //UI Address
        address = view.findViewById(R.id.textViewAddress);
        inputAddress = view.findViewById(R.id.editTextAdress);
        warningAddress = view.findViewById(R.id.textViewWarningAddress);

        //UI Country
        chooseCountry = view.findViewById(R.id.textViewCountry);
        spinnerCountry = view.findViewById(R.id.spinnerCountry);
        warningChooseCountry = view.findViewById(R.id.textViewWarningCountry);
        onHideErrorMessage();
        initSpinner();
    }

    public void onRefresh(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    public void initSpinner(){
        String[] gender = {"Male", "Female"};
        final ArrayAdapter<String> adapterGender = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,gender);
        spinnerGender.setAdapter(adapterGender);

        String[] job = {"Pengusaha", "Guru", "Pegawai Negeri", "Dokter", "Lain-Lain"};
        final ArrayAdapter<String> adapterJob = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,job);
        spinnerJob.setAdapter(adapterJob);

        String[] country = {"Indonesia", "DLL"};
        final ArrayAdapter<String> adapterCountry = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,country);
        spinnerCountry.setAdapter(adapterCountry);
    }

    @Override
    public void onErrorChangeFullNameUI() {
        fullName.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningFullname.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeEmailUI() {
        email.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningEmail.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeMotherNameUI() {
        motherName.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningMotherName.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeCardTypeUI() {
        identityNumber.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningChooseIdentityNumber.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeCardNumberUI() {
        identityNumber.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningFillIdentityNumber.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeJobUI() {
        job.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningChooseJob.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeGenderUI() {
        chooseGender.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningChooseGender.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeAddressUI() {
        address.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningAddress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChangeCountryUI() {
        chooseCountry.setTextColor(getResources().getColor(R.color.textIfEmpty,null));
        warningChooseCountry.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideErrorMessage() {
        fullName.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningFullname.setVisibility(View.INVISIBLE);

        email.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningEmail.setVisibility(View.INVISIBLE);

        motherName.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningMotherName.setVisibility(View.INVISIBLE);

        identityNumber.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningChooseIdentityNumber.setVisibility(View.INVISIBLE);
        warningFillIdentityNumber.setVisibility(View.INVISIBLE);

        chooseGender.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningChooseGender.setVisibility(View.INVISIBLE);

        job.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningChooseJob.setVisibility(View.INVISIBLE);

        address.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningAddress.setVisibility(View.INVISIBLE);

        chooseCountry.setTextColor(getResources().getColor(R.color.textIfNotEmpty,null));
        warningChooseCountry.setVisibility(View.INVISIBLE);
    }

    public void getData() {
        registerActivity.sendUserData(user);
    }

}
