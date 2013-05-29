import com.lexmark.twistagedemo.Role
import com.lexmark.twistagedemo.User
import com.lexmark.twistagedemo.UserRole

class BootStrap
{

	def init =
	{  servletContext ->

		if (!User.get(1))
		{
			def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
			def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

			def testUser = new User(username: 'test', enabled: true, password: 'changeme').save(flush: true)
			def adminUser = new User(username: 'admin', enabled: true, password: 'changeme').save(flush: true)
			def doug = new User(username: 'doug', enabled: true, password: 'changeme').save(flush: true)
			def daniel = new User(username: 'daniel', enabled: true, password: 'test').save(flush: true)

			UserRole.create testUser, userRole, true
			UserRole.create adminUser, adminRole, true
			UserRole.create doug, userRole, true
			UserRole.create daniel, adminRole, true

			assert User.count() == 4
			assert Role.count() == 2
			assert UserRole.count() == 4
		}
	}

	def destroy =
	{
	}
}
