package com.alkemy.ong.database.entities;

import lombok.Data;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name ="news")
@SQLDelete(sql = "UPDATE news SET deleted = true WHERE id =?")
@FilterDef(name = "deletedNewsFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProductFilter", condition = "deleted =isDeleted")
public class NewsEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotEmpty(message = "Name field is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "content field is required")
    @Column(name = "content",length = 250, nullable = false)
    private String content;

    @NotEmpty(message = "Image field is required")
    @Column(name = "image", nullable = false)
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.INSERT)
    @Column(name = "created_at", updatable = false, nullable = false, insertable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.ALWAYS)
    @Column(name = "updated_at", updatable = false, nullable = false, insertable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated_at;

    /*@JoinColumn(name = "fk_category", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Categories categoryId;*/

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
}
