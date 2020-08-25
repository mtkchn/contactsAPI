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

    // sort
//    private String sortColumn;
//    private String sortDirection;

}
