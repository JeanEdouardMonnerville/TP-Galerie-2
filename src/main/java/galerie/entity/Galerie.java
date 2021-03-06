package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;
import java.util.LinkedList;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA

public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany( mappedBy="organisateur")
    private List<Exposition> evenements=new LinkedList <>() ;
    
        /*@Param annee correspond à l'annee du CA demandé
         *@Return Le Chiffre d'Affaire annuel de cette annee là
        */
        public float CAannuel(int annee){
        float result=0f;
    
        for(Exposition e:evenements){
            int anneExpo =e.getDateExpo().getYear();
            if( anneExpo == annee ){
                result= result+ e.CA();
                
            }
        }
        return result;
    }

}
