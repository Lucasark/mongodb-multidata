package com.example.multi_mongo_proj.repository.modelRepo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="model_2")
@ToString
public class Model2 {
    @Id
    private String id;

    @Indexed(unique = true, background = true)
    private String uniqueOfModel2;

}
