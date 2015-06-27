package po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name="USERS")
public class User {
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="tels",joinColumns=@JoinColumn(name="u_id"))
	@Column(name="tel_code")
	private Set<String> tels=new HashSet<String>();
	
	
//	@EmbeddedId
//	@AttributeOverrides({@AttributeOverride(name="firstName",column=@Column(name="first_name")),@AttributeOverride(name="lastName",column=@Column(name="last_name"))})
//	private FullName fname;
	

	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE,generator="seq_table")
//	@TableGenerator(name="seq_table",valueColumnName="count",table="seqtable",pkColumnName="pkId",allocationSize=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(mappedBy="u",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	private Address addr;
	
	
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Set<String> getTels() {
		return tels;
	}
	public void setTels(Set<String> tels) {
		this.tels = tels;
	}
	
	@Column(name="u_name",nullable=false,length=20)
	private String uanme;
	@Transient
	private int age;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uanme, int age) {
		super();
		this.uanme = uanme;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUanme() {
		return uanme;
	}
	public void setUanme(String uanme) {
		this.uanme = uanme;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
