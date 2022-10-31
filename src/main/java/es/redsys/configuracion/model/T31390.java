package es.redsys.configuracion.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the T31390 database table.
 * 
 */
@Entity
@Table(name="T31390")
@NamedQuery(name="T31390.findAll", query="SELECT t FROM T31390 t")
public class T31390 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=4)
	private String banco;

	@Column(length=50)
	private String c01;

	@Column(length=50)
	private String c02;

	@Column(length=50)
	private String c03;

	@Column(length=50)
	private String c04;

	@Column(length=50)
	private String c05;

	@Column(length=50)
	private String c06;

	@Column(length=50)
	private String c07;

	@Column(length=50)
	private String c08;

	@Column(length=50)
	private String c09;

	@Column(length=50)
	private String c10;

	@Column(length=50)
	private String c11;

	@Column(length=50)
	private String c12;

	@Column(length=50)
	private String c13;

	@Column(length=50)
	private String c14;

	@Column(length=50)
	private String c15;

	@Column(length=50)
	private String c16;

	@Column(length=50)
	private String c17;

	@Column(length=50)
	private String c18;

	@Column(length=50)
	private String c19;

	@Column(length=50)
	private String c20;

	@Column(length=50)
	private String c21;

	@Column(length=50)
	private String c22;

	@Column(length=50)
	private String c23;

	@Column(length=50)
	private String c24;

	@Column(length=50)
	private String c25;

	@Column(length=50)
	private String c26;

	@Column(length=50)
	private String c27;

	@Column(length=50)
	private String c28;

	@Column(length=50)
	private String c29;

	@Column(length=50)
	private String c30;

	@Column(length=50)
	private String c31;

	@Column(length=50)
	private String c32;

	@Column(length=50)
	private String c33;

	@Column(length=50)
	private String c34;

	@Column(length=50)
	private String c35;

	@Column(name="FECHA_TRANS", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTrans;

	@Column(length=4)
	private String version;

	public T31390() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getC01() {
		return this.c01;
	}

	public void setC01(String c01) {
		this.c01 = c01;
	}

	public String getC02() {
		return this.c02;
	}

	public void setC02(String c02) {
		this.c02 = c02;
	}

	public String getC03() {
		return this.c03;
	}

	public void setC03(String c03) {
		this.c03 = c03;
	}

	public String getC04() {
		return this.c04;
	}

	public void setC04(String c04) {
		this.c04 = c04;
	}

	public String getC05() {
		return this.c05;
	}

	public void setC05(String c05) {
		this.c05 = c05;
	}

	public String getC06() {
		return this.c06;
	}

	public void setC06(String c06) {
		this.c06 = c06;
	}

	public String getC07() {
		return this.c07;
	}

	public void setC07(String c07) {
		this.c07 = c07;
	}

	public String getC08() {
		return this.c08;
	}

	public void setC08(String c08) {
		this.c08 = c08;
	}

	public String getC09() {
		return this.c09;
	}

	public void setC09(String c09) {
		this.c09 = c09;
	}

	public String getC10() {
		return this.c10;
	}

	public void setC10(String c10) {
		this.c10 = c10;
	}

	public String getC11() {
		return this.c11;
	}

	public void setC11(String c11) {
		this.c11 = c11;
	}

	public String getC12() {
		return this.c12;
	}

	public void setC12(String c12) {
		this.c12 = c12;
	}

	public String getC13() {
		return this.c13;
	}

	public void setC13(String c13) {
		this.c13 = c13;
	}

	public String getC14() {
		return this.c14;
	}

	public void setC14(String c14) {
		this.c14 = c14;
	}

	public String getC15() {
		return this.c15;
	}

	public void setC15(String c15) {
		this.c15 = c15;
	}

	public String getC16() {
		return this.c16;
	}

	public void setC16(String c16) {
		this.c16 = c16;
	}

	public String getC17() {
		return this.c17;
	}

	public void setC17(String c17) {
		this.c17 = c17;
	}

	public String getC18() {
		return this.c18;
	}

	public void setC18(String c18) {
		this.c18 = c18;
	}

	public String getC19() {
		return this.c19;
	}

	public void setC19(String c19) {
		this.c19 = c19;
	}

	public String getC20() {
		return this.c20;
	}

	public void setC20(String c20) {
		this.c20 = c20;
	}

	public String getC21() {
		return this.c21;
	}

	public void setC21(String c21) {
		this.c21 = c21;
	}

	public String getC22() {
		return this.c22;
	}

	public void setC22(String c22) {
		this.c22 = c22;
	}

	public String getC23() {
		return this.c23;
	}

	public void setC23(String c23) {
		this.c23 = c23;
	}

	public String getC24() {
		return this.c24;
	}

	public void setC24(String c24) {
		this.c24 = c24;
	}

	public String getC25() {
		return this.c25;
	}

	public void setC25(String c25) {
		this.c25 = c25;
	}

	public String getC26() {
		return this.c26;
	}

	public void setC26(String c26) {
		this.c26 = c26;
	}

	public String getC27() {
		return this.c27;
	}

	public void setC27(String c27) {
		this.c27 = c27;
	}

	public String getC28() {
		return this.c28;
	}

	public void setC28(String c28) {
		this.c28 = c28;
	}

	public String getC29() {
		return this.c29;
	}

	public void setC29(String c29) {
		this.c29 = c29;
	}

	public String getC30() {
		return this.c30;
	}

	public void setC30(String c30) {
		this.c30 = c30;
	}

	public String getC31() {
		return this.c31;
	}

	public void setC31(String c31) {
		this.c31 = c31;
	}

	public String getC32() {
		return this.c32;
	}

	public void setC32(String c32) {
		this.c32 = c32;
	}

	public String getC33() {
		return this.c33;
	}

	public void setC33(String c33) {
		this.c33 = c33;
	}

	public String getC34() {
		return this.c34;
	}

	public void setC34(String c34) {
		this.c34 = c34;
	}

	public String getC35() {
		return this.c35;
	}

	public void setC35(String c35) {
		this.c35 = c35;
	}

	

	public Date getFechaTrans() {
		return fechaTrans;
	}

	public void setFechaTrans(Date fechaTrans) {
		this.fechaTrans = fechaTrans;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T31390 [id=");
		builder.append(id);
		builder.append(", banco=");
		builder.append(banco);
		builder.append(", c01=");
		builder.append(c01);
		builder.append(", c02=");
		builder.append(c02);
		builder.append(", c03=");
		builder.append(c03);
		builder.append(", c04=");
		builder.append(c04);
		builder.append(", c05=");
		builder.append(c05);
		builder.append(", c06=");
		builder.append(c06);
		builder.append(", c07=");
		builder.append(c07);
		builder.append(", c08=");
		builder.append(c08);
		builder.append(", c09=");
		builder.append(c09);
		builder.append("]");
		return builder.toString();
	}
	
	

}