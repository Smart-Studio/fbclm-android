/*
 * Copyright 2015 Smart Studio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smartstudio.fbclm.model;

/**
 * Represents a league
 **/
public class League {
    public static final String ADDECO_PLATA = "ADECCO PLATA T";
    public static final String EBA = "EBA";
    public static final String NACIONAL = "1ª NACIONAL MASCULINA";
    public static final String AUTONOMICA_1 = "1ª AUTONOMICA MASCULINA ";
    public static final String FEM_1 = "1ª DIVISION FEMENINA CLM";
    public static final String AUTONOMICA_2 = "2ª AUTONOMICA MASCULINA";
    public static final String SUB_20_MAS = "SUB-20 MASCULINA";
    public static final String SUB_20_FEM = "SUB-20 FEMENINA";
    public static final String JUNIOR_MAS_ESPECIAL = "JUNIOR MASCULINO ESPECIAL";
    public static final String JUNIOR_FEM ="JUNIOR FEMENINO";
    public static final String JUNIOR_MAS_PREFERENTE = "JUNIOR MASCULINO PREFERENTE";


    private int id;
    private String name;

    public League() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
