package com.example.multi_mongo_proj.repository.modelRepo1;

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
@Document(collection="model_1")
@ToString
public class Model1 {

    @Id
    private String id;

    @Indexed(unique = true, background = true)
    private String uniqueOfModel1;

}
