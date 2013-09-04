var APP = (function() {

	var APP = window.APP = window.APP || {
		Routers : {},
		Collections : {},
		Models : {},
		Views : {}
	};

	APP.Routers.Router = Backbone.Router.extend({
		routers: {
			login: 'login',
			index: 'login'
		},

		initialize: function () {		
			this.login();
		},

		login: function () {
			this.currentView = new APP.Views.LoginFormView();
			$('#wrapper').append(this.currentView.render().$el);
		}
	});
	
	APP.Views.ErrorView = Backbone.View.extend({
		template: doT.template($('#errors-template').html()),
		render: function () {
			var errorEl = $(this.template({errors: this.model})),
				wrapper = $('#wrapper');
			wrapper
				.children('.error')
				.remove();
			
			wrapper
				.append(errorEl.fadeIn());
			
			setTimeout(function () {
				errorEl.fadeOut();
			}, 5000);
		}
	});

	APP.Views.LoginFormView = Backbone.View.extend({
		render: function () {
			this.setElement($('#login-form-template').html());
			return this;
		},
		
		events: {
			submit: function () {
				var admin = new APP.Models.Admin(this.$el.serilizeIndexedArray()),
					errorView,
					errors = [];
				
				if (admin.get('login') === '') {
					errors.push('login is required');
				}
				
				if (admin.get('password') === '') {
					errors.push('password is required');
				}
				
				if (errors.length !== 0) {
					errorView = new APP.Views.ErrorView({model: errors});
					errorView.render();
				} else {
					this.$el.ajaxSubmit();
				}
				return false;
			}
		}
	});

	APP.Models.Admin = Backbone.Model.extend({
		defaults: {
			login: '',
			password: ''
		}
	});

	return APP;
})();

$(function () {
	var router = new APP.Routers.Router();
});

(function ($) {
	$.fn.serilizeIndexedArray = function () {
		var unidexedArray = this.serializeArray(),
			indexedArray = {};

		$.map(unidexedArray, function (el) {
			indexedArray[el.name] = el.value;
		});
		return indexedArray;
	}
})(jQuery);
