/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cdi105
 */
@Entity
public class Vente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private float montantInitial;
private float montantReserve;
private Date dateDebut;
private int duree;
private String etat;
@OneToMany(mappedBy = "vente")
private Collection<Enchere> encheres;
@ManyToOne()
private Vente vente;
@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
private Collection<Utilisateur> users;
@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
private Produit produit;
    public Vente() {
        users=new ArrayList();
        encheres=new ArrayList<>();
    }

    public Vente(float montantInitial, float montantReserve, Date dateDebut, int duree, String etat) {
        this();
        this.montantInitial = montantInitial;
        this.montantReserve = montantReserve;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.etat = etat;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMontantInitial() {
        return montantInitial;
    }

    public void setMontantInitial(float montantInitial) {
        this.montantInitial = montantInitial;
    }

    public float getMontantReserve() {
        return montantReserve;
    }

    public void setMontantReserve(float montantReserve) {
        this.montantReserve = montantReserve;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Collection<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(Collection<Enchere> encheres) {
        this.encheres = encheres;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public Collection<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(Collection<Utilisateur> users) {
        this.users = users;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Vente[ id=" + id + " ]";
    }
    
}
