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

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a league
 **/
public class League implements Parcelable {
    public static final String ADDECO_PLATA = "ADECCO PLATA T";
    public static final String EBA = "EBA";
    public static final String NACIONAL = "1ª NACIONAL MASCULINA";
    public static final String AUTONOMICA_1 = "1ª AUTONOMICA MASCULINA ";
    public static final String FEM_1 = "1ª DIVISION FEMENINA CLM";
    public static final String AUTONOMICA_2 = "2ª AUTONOMICA MASCULINA";
    public static final String SUB_20_MAS = "SUB-20 MASCULINA";
    public static final String SUB_20_FEM = "SUB-20 FEMENINA";
    public static final String JUNIOR_MAS_ESPECIAL = "JUNIOR MASCULINO ESPECIAL";
    public static final String JUNIOR_FEM = "JUNIOR FEMENINO";
    public static final String JUNIOR_MAS_PREFERENTE = "JUNIOR MASCULINO PREFERENTE";

    public static final Creator<League> CREATOR = new Creator<League>() {
        @Override
        public League createFromParcel(Parcel in) {
            return new League(in);
        }

        @Override
        public League[] newArray(int size) {
            return new League[size];
        }
    };

    private int id;
    private String name;
    private List<Group> groups;

    public League() {

    }

    protected League(Parcel in) {
        id = in.readInt();
        name = in.readString();
        if (groups == null) {
            groups = new ArrayList<>();
        }
        in.readTypedList(groups, Group.CREATOR);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public boolean hasGroups(){
        return groups != null && !groups.isEmpty();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeTypedList(groups);
    }
}
