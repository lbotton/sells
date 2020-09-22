package com.botton.sells.config.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.botton.sells.audit.CustomAuditEntityListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@EntityListeners(CustomAuditEntityListener.class)
public class BaseEntity<ID> implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private ID id;

  @Column
  private String ipNumberUpdate;

  @Column
  private Long userCreate;

  @Column
  private Long userUpdate;

  @Column
  @LastModifiedDate
  private LocalDateTime dateUpdate;

  @Column
  private String ipNumberCreate;

  @Column
  @CreatedDate
  private LocalDateTime dateCreate;

}

