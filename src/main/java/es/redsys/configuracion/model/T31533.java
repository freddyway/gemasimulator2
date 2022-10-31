package es.redsys.configuracion.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the T31533 database table.
 * 
 */
@Entity
@Table(name="T31533")
@NamedQuery(name="T31533.findAll", query="SELECT t FROM T31533 t")
public class T31533 implements Serializable {
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

	@Column(name="FECHA_TRANS", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTrans;

	@Column(length=4)
	private String version;

	public T31533() {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T31533 [id=");
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
		builder.append(", fechaTrans=");
		builder.append(fechaTrans);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	
}