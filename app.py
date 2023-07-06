from flask import Flask, make_response , render_template, request , redirect 
import mysql.connector as connector

app = Flask(__name__)
app.secret_key = "secret"

def DBinit():
    con = connector.connect(host = 'localhost', 
                            port ='3306' , 
                            user = 'root', 
                            password = '1234' , 
                            database = 'Car_Rental')
    query = "create table if not exists cars (id integer auto_increment primary key ,name varchar(255) not null, price integer not null)"                             
    query1 = "create table if not exists rentedcars (id integer auto_increment primary key ,name varchar(255) not null, price integer not null)"
    query2 = "create table if not exists users (id integer auto_increment primary key ,name varchar(255) not null , email varchar(255) not null, password varchar(255) not null)"
    query3 = "create table if not exists details (id integer auto_increment primary key  , name varchar(255) , location varchar(255) , pickup_date varchar(255) , return_date varchar(255) )"
    cur = con.cursor()
    cur.execute(query)
    cur.execute(query1)
    cur.execute(query2)
    cur.execute(query3)
    print("connected")
    return con

@app.route('/', methods = ['GET','POST'])
def index():
    if request.method == 'POST': 
        if "signup" in request.form: 
            name = request.form['name']
            email = request.form['email']
            password = request.form['password']
            query = ("insert into users(name,email,password) values('{}','{}','{}')".format(name.strip(), email  .strip(), password.strip()))
            cur = conn.cursor()
            cur.execute(query)
            conn.commit()
            return redirect('/')
        
        if "signin" in request.form:
            
            name = request.form['name']
            password = request.form['password']
            query = ('select * from users where name=%s and password=%s')
            cur = conn.cursor()
            cur.execute(query,(name,password))
            row=cur.fetchone()
            print(row) 
            if row!=None:
                userres = make_response(render_template('index.html'))
                userres.set_cookie('name',name)
                return userres
            else:
                return render_template('test.html')

        if "details" in request.form:
            location = request.form['location']
            pickdate = request.form['pickdate']
            returndate = request.form['returndate']
            name = request.cookies.get('name')
            query = ("insert into details(name,locaion,pickup_date,rerurn_date) values('{}','{}','{}','{}')".format(name.strip(), location.strip(), pickdate.strip(), returndate.strip(), returndate.strip()))
            

    return render_template('index.html')

@app.route('/test.html')
def test():
    render_template('test.html')


@app.route('/rent', methods=['GET', 'POST'])
def rent():
    if request.method == 'POST':
        # Handle form submission and create reservation
        car_id = request.form['car_id']
        start_date = request.form['start_date']
        end_date = request.form['end_date']
        pickup_location = request.form['pickup_location']
        return_location = request.form['return_location']
        #create reservation in database
        return render_template('confirmation.html', car_id=car_id, start_date=start_date, end_date=end_date, pickup_location=pickup_location, return_location=return_location)
    else:
        cars = [
            {'id': 1, 'name': 'Car 1', 'price': 50},
            {'id': 2, 'name': 'Car 2', 'price': 60},
            # More cars
        ]
        return render_template('reserve.html', cars=cars)


         
if __name__ == '__main__':
    conn = DBinit()
    app.run(debug=True)
    
    
