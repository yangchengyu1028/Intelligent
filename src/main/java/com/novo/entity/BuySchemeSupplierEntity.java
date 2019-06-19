package com.novo.entity;


/**
 * 方案商品和供应商中间表
 * @author ycy
 *
 */
/*@Entity
@Table(name="BuySchemeSupplier")
@JsonIgnoreProperties(ignoreUnknown=true)
public class BuySchemeSupplierEntity implements java.io.Serializable{

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -5290153980755144836L;
	private int id;
	private SupplierEntity supp;
	private BuySchemeEntity bs;
	public BuySchemeSupplierEntity() {

	}
	public BuySchemeSupplierEntity(int id, SupplierEntity supp, BuySchemeEntity bs) {
		this.id = id;
		this.supp = supp;
		this.bs = bs;
	}
	@Id
	@Column(name = "bss_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bss_s_id")
	public SupplierEntity getSupp() {
		return supp;
	}
	public void setSupp(SupplierEntity supp) {
		this.supp = supp;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bss_bs_id")
	public BuySchemeEntity getBs() {
		return bs;
	}
	public void setBs(BuySchemeEntity bs) {
		this.bs = bs;
	}
	
}
*/