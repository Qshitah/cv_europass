package ntt.cv.europass.service;

import ntt.cv.europass.entity.Client;
import ntt.cv.europass.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends MainService<Client, Long> {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository repository, ClientRepository clientRepository) {
        super(repository);
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client entity) {
        if(entity == null){
            return  null;
        }
        Client clientExist = clientRepository.findByName(entity.getName());
        if(clientExist != null){
            return clientExist;
        }
        return super.save(entity);
    }
}