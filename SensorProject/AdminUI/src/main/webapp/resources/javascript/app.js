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

	APP.Views.LoginFormView = Backbone.View.extend({
		render: function () {
			this.setElement($('#login-form-template').html());
			return this;
		},
		
		validate: function (formData) {
			for (var i = 0; i < formData.length; i++) {
				
			}
		},
		
		events: {
			submit: function () {
				var admin = new APP.Models.Admin();
				this.$el.ajaxSubmit();
				return false;
			}
		}
	});

	APP.Models.Admin = Backbone.Model.extend({
		defaults: {
			login: '',
			password: ''
		},

		validate: function (attrs) {
			var errors = {};
			if (attrs.login === '') {
				errors.login = "Please enter login";
			}
			if (attrs.password === '') {
				errors.password = "Please enter password";
			}

			return errors;
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
