package com.zboss.fw.core.model;

import com.zboss.fw.core.model.FwHelloOne.HelloOneEnum;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-06-13T19:18:32.008+0800")
@StaticMetamodel(FwHelloOne.class)
public class FwHelloOne_ {
	public static volatile SingularAttribute<FwHelloOne, String> id;
	public static volatile SingularAttribute<FwHelloOne, String> stringOne;
	public static volatile SingularAttribute<FwHelloOne, Integer> integerOne;
	public static volatile SingularAttribute<FwHelloOne, Float> floatOne;
	public static volatile SingularAttribute<FwHelloOne, Double> doubleOne;
	public static volatile SingularAttribute<FwHelloOne, BigDecimal> moneyOne;
	public static volatile SingularAttribute<FwHelloOne, Date> dateOne;
	public static volatile SingularAttribute<FwHelloOne, Boolean> boolOne;
	public static volatile SingularAttribute<FwHelloOne, Long> longOne;
	public static volatile SingularAttribute<FwHelloOne, HelloOneEnum> enumOne;
	public static volatile SingularAttribute<FwHelloOne, byte[]> blobOne;
	public static volatile SingularAttribute<FwHelloOne, String> clobOne;
	public static volatile SetAttribute<FwHelloOne, FwHelloTwo> fwHelloTwos;
}
