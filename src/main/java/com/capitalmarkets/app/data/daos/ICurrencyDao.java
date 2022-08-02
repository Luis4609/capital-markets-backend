package com.capitalmarkets.app.data.daos;

import com.capitalmarkets.app.data.entities.CurrencyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICurrencyDao extends JpaRepository<CurrencyModel,String> {


    Optional<CurrencyModel> getByCurrencyName(String name);

    Optional<CurrencyModel> getByCurrencyCode(String code);

}
