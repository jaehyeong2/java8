package jjfactory.javathe.rep;

import jjfactory.javathe.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTestRepository extends JpaRepository<Member,Long> {
}
