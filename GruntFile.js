module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';'
            },
            dist: {
                src: ['static/src/**/*.js'],
                dest: 'static/dist/js/<%= pkg.name %>.js'
            }
        },
        // uglify: {
        //     options: {
        //         banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd hh:MM:ss") %>*/\n'
        //     },
        //     dist: {
        //         files: {
        //             'dist/<%= pkg.name %>.min.js': ['<%= concat.dist.dest %>']
        //         }
        //     }
        // },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n' //添加banner
            },
            buildall: {
                options: {
                    mangle: true,
                    compress: {
                        drop_console: true
                    },
                    report: "min" //输出压缩率，可选的值有 false(不输出信息)，gzip
                },
                files: 
                // [{
                //     expand: true,
                //     cwd: 'static/src', //js目录下
                //     src: '**/*.js', //所有js文件
                //     dest: 'dist' //输出到此目录下
                // }]
                [
                    {dest:'static/dist/js/lib.js',src:[
                            'static/frame/js/angular.min.js',
                            'static/frame/js/angular-ui-router.min.js',
                            'static/frame/js/jquery.js',
                            'static/frame/js/bootstrap.min.js'
                            ]},
                    {dest:'static/dist/js/esms.min.js',src:'static/dist/js/<%= pkg.name %>.js'}
                ]
            }
        },
        //压缩CSS
        cssmin: {
          generated: {
            files: {
              'static/dist/css/style.min.css': ['static/src/less/style.css'],
              'static/dist/css/font.css': ['static/frame/fonts/**/**/*.css']
            }
          }
        },
        //压缩图片
        imagemin: {
          dynamic: {
            options: {
              optimizationLevel: 7,
              pngquant: true
            },
            files: [{expand: true, 
                cwd: 'images/', 
                src: ['static/src/img/*.{png,jpg,jpeg,gif,webp,svg}'], 
                dest: 'dist/images'
            }]
          }
        },
        qunit: {
            // options: {
            //     timeout: 10000,
            //     '--cookies-file': 'misc/cookies.txt'
            // },
            // files: ['test/**/*.html']
            all: {
                options: {
                    urls: [
                        'http://localhost:3000/test/index.html',
                    ]
                }
            }
        },
        jshint: {
            files: ['static/**/*.js'],
            options: {
                //覆盖默认配置
                globals: {
                    jQuery: true,
                    console: true,
                    module: true,
                    document: true
                }
            }
        },
        watch: {
            scripts: {
                files: ['static/**/*.js', 'static/**/**/*.js'],
                tasks: ['minall'],
                options: {
                    spawn: true,
                    interrupt: true
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-imagemin');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-qunit');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');

    grunt.registerTask('minall', ['uglify:buildall']);
    grunt.registerTask('unittest', ['connect', 'qunit']);
    grunt.registerTask('test', ['jshint', 'qunit']);
    grunt.registerTask('full', ['jshint', 'qunit', 'concat', 'uglify']);
    grunt.registerTask('default', ['concat', 'uglify','cssmin','imagemin']);
};