package com.splitwise.splitwise.models;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    List<ExpenseUser> expenseUsers;
}

/*

    1           M
expense ---- user
    M           1

MTM

    1           M
expense ---- expenseuser
    1           1

 */
