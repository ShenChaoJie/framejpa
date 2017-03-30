package org.frame.common.db;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.type.StandardBasicTypes;


public class MMySQLDialect extends MySQL5Dialect {
	public MMySQLDialect () {
		  super();
		  registerHibernateType(Types.DECIMAL, StandardBasicTypes.BIG_DECIMAL.getName());
		  registerHibernateType(Types.LONGVARBINARY,StandardBasicTypes.STRING.getName());
		  registerHibernateType(Types.LONGVARCHAR,StandardBasicTypes.STRING.getName());
		  registerHibernateType(Types.BINARY,StandardBasicTypes.STRING.getName());
		  registerHibernateType(-1,StandardBasicTypes.STRING.getName());
    }
}
