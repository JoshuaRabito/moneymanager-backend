package moneymanager.backend.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserEntity.class)
public class UserEntity_ {

  public static volatile SingularAttribute<UserEntity, String> firstName;
  public static volatile SingularAttribute<UserEntity, String> lastName;
  public static volatile SingularAttribute<UserEntity, Long> userId;
  public static volatile SingularAttribute<UserEntity, String> email;
}
