package com.zboss.fw.core.model;

import com.zboss.fw.core.model.FwHelloTwo.HelloTwoEnum;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-06-13T19:18:32.010+0800")
@StaticMetamodel(FwHelloTwo.class)
public class FwHelloTwo_ {
	public static volatile SingularAttribute<FwHelloTwo, String> id;
	public static volatile SingularAttribute<FwHelloTwo, String> stringTwo;
	public static volatile SingularAttribute<FwHelloTwo, Integer> integerTwo;
	public static volatile SingularAttribute<FwHelloTwo, Float> floatTwo;
	public static volatile SingularAttribute<FwHelloTwo, Double> doubleTwo;
	public static volatile SingularAttribute<FwHelloTwo, BigDecimal> moneyTwo;
	public static volatile SingularAttribute<FwHelloTwo, Date> dateTwo;
	public static volatile SingularAttribute<FwHelloTwo, Boolean> boolTwo;
	public static volatile SingularAttribute<FwHelloTwo, Long> longTwo;
	public static volatile SingularAttribute<FwHelloTwo, byte[]> blobTwo;
	public static volatile SingularAttribute<FwHelloTwo, String> clobTwo;
	public static volatile SingularAttribute<FwHelloTwo, FwHelloOne> fwHelloOne;
	public static volatile SingularAttribute<FwHelloTwo, HelloTwoEnum> enumTwo;
}
