package shop.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CoreApplicationTests {

	@RequiredArgsConstructor
	@Getter
	public static class Member1 {
		private String name;
		private final String team;
		private int age;

	}
	@Getter
	@AllArgsConstructor
	public static class Member2 {
		private String name;
		private final String team;
		private int age;
	}

	@Test
	void test() {
		Member1 member1 = new Member1("CX");
		Member2 member2 = new Member2("11st","CX",27);
		assertThat(member1.getTeam()).isEqualTo("CX");
		assertThat(member2.getTeam()).isEqualTo("CX");
	}



	@RequiredArgsConstructor
	@Builder
	@Getter
	public static class User {
		private final String login;
		private final String firstName;
		private final String lastName;
		private final int age;
		private final ZonedDateTime registeredTime;
		private final ZonedDateTime lastAuthTime;
	}

	@Test
	void builderTest() {
		ZonedDateTime registeredTime = null;
		ZonedDateTime lastAuthTime = null;
		User user1 = new User(
			"john_brown",
			"John",
			"Brown",
			34,
			registeredTime,
			lastAuthTime
		);

		final User user2 = User.builder()
//							   .firstName("John")
							   .lastName("Brown")
							   .login("1101411")
//							   .age(22)
							   .lastAuthTime(lastAuthTime)
							   .registeredTime(registeredTime)
							   .build();
		assertThat(user2.getFirstName()).isNull();
	}

	@Setter
	@EqualsAndHashCode
	public static class Order1 {

		@EqualsAndHashCode.Include
		private Long orderId;
		private long orderPrice;
		private long cancelPrice;

		public Order1(Long orderId, long orderPrice, long cancelPrice) {
			this.orderId = orderId;
			this.orderPrice = orderPrice;
			this.cancelPrice = cancelPrice;
		}
	}

	@Test
	void enqTest() {
		Order1 order = new Order1(1000L, 19800L, 0L);

		Set<Order1> orders = new HashSet<>();
		orders.add(order);// Set에 객체 추가

		System.out.println(order.hashCode());

		order.setCancelPrice(5000L);
		System.out.println(order.hashCode());

		assertThat(orders.contains(order)).isTrue();

	}

	@Setter
	public static class Order2 {
		private Long orderId;
		private long orderPrice;
		private long cancelPrice;

		public Order2(Long orderId, long orderPrice, long cancelPrice) {
			this.orderId = orderId;
			this.orderPrice = orderPrice;
			this.cancelPrice = cancelPrice;
		}


		@Override
		public boolean equals(Object o) {
			if (this == o) { return true; }
			if (o == null || getClass() != o.getClass()) { return false; }
			Order2 order2 = (Order2) o;
			return orderPrice == order2.orderPrice && cancelPrice == order2.cancelPrice && Objects.equals(orderId, order2.orderId);
		}

		@Override
		public int hashCode() {
			return Objects.hash(orderId);
		}
	}

	@Test
	void enqTest2() {
		Order2 order = new Order2(1000L, 19800L, 0L);

		Set<Order2> orders = new HashSet<>();
		orders.add(order);// Set에 객체 추가


		System.out.println(order.hashCode());

		order.setCancelPrice(5000L);
		System.out.println(order.hashCode());

		assertThat(orders.contains(order)).isTrue();

	}
}
