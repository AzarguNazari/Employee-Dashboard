import React, {Component} from 'react';
import Alert from '@material-ui/lab/Alert';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import {Grid, Link, Checkbox, Avatar, Button, CssBaseline, TextField, Typography} from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';

export default class SignIn extends Component{

    constructor(props) {
        super(props);
        this.state = {
            classes: makeStyles((theme) => ({
                paper: {
                    marginTop: theme.spacing(8),
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                },
                avatar: {
                    margin: theme.spacing(1),
                    backgroundColor: theme.palette.secondary.main,
                },
                form: {
                    width: '100%', // Fix IE 11 issue.
                    marginTop: theme.spacing(1),
                },
                submit: {
                    margin: theme.spacing(3, 0, 2),
                },
                margin: {
                    marginTop: 20
                }
            })),
            error: false
        }

    }

    render(){
        return (
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <div className={this.state.classes.paper}>
                    <Avatar className={this.state.classes.avatar}>
                        <LockOutlinedIcon />
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign in
                    </Typography>
                    <form className={this.state.classes.form} noValidate>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            label="Email Address"
                            name="email"
                            autoComplete="email"
                            autoFocus
                        />
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Password"
                            type="password"
                            id="password"
                            autoComplete="current-password"
                        />
                        <FormControlLabel
                            control={<Checkbox value="remember" color="primary" />}
                            label="Remember me"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            color="primary"
                            className={this.state.classes.submit}
                        >
                            Sign In
                        </Button>
                        <Grid container>
                            <Grid item xs>
                                <Link href="#" variant="body2">
                                    Forgot password?
                                </Link>
                            </Grid>
                            <Grid item>
                                <Link href="#" variant="body2">
                                    {"Don't have an account? Sign Up"}
                                </Link>
                            </Grid>
                        </Grid>
                    </form>
                </div>

                {
                    this.state.error? <Alert variant="filled" severity="error" style={{marginTop: 20}}>
                                This is an error alert — check it out!
                                </Alert>: ''
                }

            </Container>
        );
    }

}