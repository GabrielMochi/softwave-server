package br.net.sofwave.server.service;

import br.net.sofwave.server.domain.Comentario;
import br.net.sofwave.server.domain.ComentarioPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

@Stateless
@Path("br.net.sofwave.server.domain.comentario")
public class ComentarioFacadeREST extends AbstractFacade<Comentario> {

    @PersistenceContext(unitName = "br.net.softwave_server_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    private ComentarioPK getPrimaryKey(PathSegment pathSegment) {
        br.net.sofwave.server.domain.ComentarioPK key = new br.net.sofwave.server.domain.ComentarioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> comentador = map.get("comentador");
        if (comentador != null && !comentador.isEmpty()) {
            key.setComentador(new java.lang.Integer(comentador.get(0)));
        }
        java.util.List<String> blogId = map.get("blogId");
        if (blogId != null && !blogId.isEmpty()) {
            key.setBlogId(new java.lang.Integer(blogId.get(0)));
        }
        java.util.List<String> receptor = map.get("receptor");
        if (receptor != null && !receptor.isEmpty()) {
            key.setReceptor(new java.lang.Integer(receptor.get(0)));
        }
        java.util.List<String> blogareaConhecimentoid = map.get("blogareaConhecimentoid");
        if (blogareaConhecimentoid != null && !blogareaConhecimentoid.isEmpty()) {
            key.setBlogareaConhecimentoid(new java.lang.Integer(blogareaConhecimentoid.get(0)));
        }
        return key;
    }

    public ComentarioFacadeREST() {
        super(Comentario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Comentario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Comentario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.ComentarioPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Comentario find(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.ComentarioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Comentario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Comentario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
