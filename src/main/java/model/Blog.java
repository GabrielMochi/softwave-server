package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlogPK id;

	private String enderecoConeteudo;

	//bi-directional many-to-one association to Postagem
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="postagem_areaConhecimento_id", referencedColumnName="areaConhecimento_id"),
		@JoinColumn(name="postagem_id", referencedColumnName="id"),
		@JoinColumn(name="postagem_usuario_prontuario", referencedColumnName="usuario_prontuario")
		})
	private Postagem postagem;

	public Blog() {
	}

	public BlogPK getId() {
		return this.id;
	}

	public void setId(BlogPK id) {
		this.id = id;
	}

	public String getEnderecoConeteudo() {
		return this.enderecoConeteudo;
	}

	public void setEnderecoConeteudo(String enderecoConeteudo) {
		this.enderecoConeteudo = enderecoConeteudo;
	}

	public Postagem getPostagem() {
		return this.postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

}