package org.example.recursos;

import io.dropwizard.jersey.params.LongParam;
import org.example.entidades.Aluno;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    private List<Aluno> bancoDados;

    public AlunoResource() {
        bancoDados = new ArrayList();
        bancoDados.add(new Aluno(123, "Joaquim", "Pessôa", "Ciência da Computação", 3));
        bancoDados.add(new Aluno(321, "Célia", "Almeida", "Gastronomia", 1));
        bancoDados.add(new Aluno(198, "Paulo", "José", "Ciência da Computação", 8));
        bancoDados.add(new Aluno(891, "Camila", "Ferreira", "Biomedicina", 4));
    }

    @GET
    public List<Aluno> getAlunos() {
        return this.bancoDados;
    }

    @POST
    public Aluno createAluno(Aluno aluno) {
        if(aluno == null){
            throw new BadRequestException("Você precisa informar todos os dados de um aluno");
        }
        if(aluno.getNome() == null || aluno.getSobrenome() == null || aluno.getCurso() == null || aluno.getSemestre() == 0) {
            throw new BadRequestException("Nome, sobrenome, curso e semestre devem ser informado");
        }

        for(Aluno a: bancoDados) {
            if (a.getTia() == aluno.getTia()) {
                throw new BadRequestException("Já existe um aluno com este TIA");
            }
        }

        this.bancoDados.add(aluno);
        return aluno;
    }

    @PUT
    @Path("{id}")
    public Aluno update(@PathParam("id") LongParam id, Aluno p) {
        for (Aluno aluno: bancoDados) {
            if (aluno.getTia() == id.get()) {
                aluno.setNome(p.getNome());
                aluno.setSobrenome(p.getSobrenome());
                aluno.setCurso(p.getCurso());
                aluno.setSemestre(p.getSemestre());
                return aluno;
            }
        }
        return null;
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        Aluno p = null;
        for (Aluno aluno: bancoDados) {
            if (aluno.getTia() == id.get()) {
                p = aluno;
                break;
            }
        }
        if (p != null) {
            bancoDados.remove(p);
        }
        else {
            throw new WebApplicationException("Aluno com Tia = " + id.get()
                    + " não encontrado!", 404);
        }
        return Response.ok().build();
    }
}
