package es.redsys.configuracion.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the T01026 database table.
 * 
 */
@Entity
@Table(name="T01026")
@NamedQuery(name="T01026.findAll", query="SELECT t FROM T01026 t")
public class T01026 implements Serializable {
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

	@Column(name="FECHA_TRANS", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTrans;

	@Column(length=4)
	private String version;

	public T01026() {
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

	public Date getFechaTrans() {
		return this.fechaTrans;
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

	public String getC04() {
		return c04;
	}

	public void setC04(String c04) {
		this.c04 = c04;
	}

	public String getC05() {
		return c05;
	}

	public void setC05(String c05) {
		this.c05 = c05;
	}

	public String getC06() {
		return c06;
	}

	public void setC06(String c06) {
		this.c06 = c06;
	}

	public String getC07() {
		return c07;
	}

	public void setC07(String c07) {
		this.c07 = c07;
	}

	public String getC08() {
		return c08;
	}

	public void setC08(String c08) {
		this.c08 = c08;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T01026 [id=");
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
		builder.append(", fechaTrans=");
		builder.append(fechaTrans);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}


	
}