package com.example.datatest.child;

import com.example.datatest.AbstractService;
import com.example.datatest.parent.ParentEntity;
import com.example.datatest.parent.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class ChildService extends AbstractService<ChildEntity> {

    private final ParentRepository parentRepository;


    public ChildService(ChildRepository childRepository,
                        ParentRepository parentRepository) {
        super(childRepository);
        this.parentRepository = parentRepository;
    }

    @Override
    public ChildEntity save(ChildEntity childEntity) {
        ParentEntity parentEntity = parentRepository.findByIdForceIncrement(childEntity.getParentEntity().getId());
        Objects.requireNonNull(parentEntity);

        return super.save(childEntity);
    }

}
