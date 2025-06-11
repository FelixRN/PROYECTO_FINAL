package com.pfrñfe.controller;

import java.util.Map;

public interface IExpenseController {

    public Map<String, Object> getLastExpenseByCarId(int carId);
}
