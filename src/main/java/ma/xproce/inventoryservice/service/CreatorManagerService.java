package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreatorManagerService implements CreatorManager{
    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    public Creator addCreator(Creator creator) {
        try{
            return creatorRepository.save(creator);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Creator updateCreator(Creator creator) {
        try{
            return creatorRepository.save(creator);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteCreator(Creator creator) {
        try{
            creatorRepository.delete(creator);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Creator findCreator(Creator creator) {
        try{
            return creatorRepository.findById(creator.getId()).get();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Creator findCreatorById(int id) {
        try{
            return creatorRepository.findById(id).get();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Creator> getAllCreator() {
        try{
            return creatorRepository.findAll();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
