package com.contacts.backend.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ContactsSearchValues {
    // pagination
    private Integer pageNumber;
    private Integer pageSize;

    //seatch
    private String name;
    private String type;
    private String email;
    private String phone;

    // sorting
    private String sortColumn;
    private String sortDirection;

}
